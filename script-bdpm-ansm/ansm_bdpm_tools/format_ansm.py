import re
import warnings

class ansm_indication :
    medication_name : str
    severity : str

    def __init__(self,medication_name,severity) :
        self.severity = severity
        self.medication_name = medication_name
    
    def __eq__(self,other) :
        if not isinstance(other,ansm_indication) :
            return NotImplemented
        return self.medication_name == other.medication_name and self.severity == other.severity
    
    def __str__(self) :
        return f"+ " + self.medication_name + " -> " + self.severity

class ansm_medication :
    name : str
    indications : list[ansm_indication]

    def __init__(self,name,indic=[]) :
        self.name = name
        self.indications = indic

    def __eq__(self,other) :
        if not isinstance(other,ansm_medication) :
            return NotImplemented
        if (self.name != other.name) :
            return False
        for indic in self.indications :
            if indic not in other.indications :
                return False
        return True
    
    def __str__(self) : # pragma: no cover
        return self.name + " indics : " + str([indic.__str__() for indic in self.indications])

def parse_highest_severity(sev_text : str,warn=True) -> str :
    if re.search(r"(CI - )|( - CI)|([cC]ontre-indication)|(CONTRE-INDICATION)",sev_text) :
        return "CI"
    elif re.search(r"(ASDEC - )|( - ASDEC)|(Association DECONSEILLEE)|(Association déconseillée)",sev_text) :
        return "ASDEC"
    elif re.search(r"(APEC - )|( - APEC)|(A prendre en compte)",sev_text) :
        return "APEC"
    elif re.search(r"(PE - )|( - PE)|([Pp]récaution d'emploi)",sev_text) :
        return "PE"
    # Send a warning when no matchs are found
    if warn : # pragma: no cover
        warnings.warn("No clear severity detected, marking as Undefined")
    return "Undefined"

def parse_ansm_indications(inidc_text : str) -> list[ansm_indication] :
    indic_list = []
    # Same principle as parse_ansm_medication_list
    # Matching every line that start by a +
    prev_end=0
    prev_name=""
    indic_match_list = re.finditer(r"^\+.*$",inidc_text,re.MULTILINE)
    for match in indic_match_list :
        if prev_end > 0 :
            indic_list.append(ansm_indication(
                prev_name.lstrip(),
                parse_highest_severity(inidc_text[prev_end+1:match.start()])
            ))
        prev_name = match.group()[1:]
        prev_end = match.end()  
    indic_list.append(ansm_indication(prev_name.lstrip(),parse_highest_severity(inidc_text[prev_end+1:])))
    return indic_list

# Parse the ansm txt file with regex
def parse_ansm_medication_list(ansm_text : str) -> list[ansm_medication] :
    med_list = []
    # Find every medication by name
    med_regex_matchs = re.finditer(
        r"^(?!((ASDEC|CI|PE|APEC) - )|(CONTRE-INDICATION))[A-ZÀ-Ý][A-ZÀ-Ý\s\(\-\),Œ\/]+$",
        ansm_text,
        re.MULTILINE
    )
    # Itterate over every match
    # Use the start of the next match to delimit the text
    prevmed_end = 0
    prev_name=""
    for match in med_regex_matchs :
        if prevmed_end > 0 : # Add previous med
            med_list.append(ansm_medication(
                prevmed_name,
                parse_ansm_indications(ansm_text[prevmed_end+1:match.start()])
            )
        )
        prevmed_name = match.group()
        prevmed_end = match.end()
    # Explicitly add the last match
    med_list.append(ansm_medication(
        prevmed_name,
        parse_ansm_indications(ansm_text[prevmed_end+1:])
    ))
    return med_list

def parse_ansm(ansm_txt_path : str) -> list[ansm_medication] : # pragma: no cover
    # Read the text file converted by decoder.py
    with open(ansm_txt_path) as ansm_src :
        ansm_data = parse_ansm_medication_list(ansm_src.read())
    return ansm_data

def main() : # pragma: no cover
    print("Mode test :")
    parse_ansm(
        "sources/formated/thesaurus-interactions-medicamenteuses.txt"
    )

if __name__  == "__main__": # pragma: no cover
    main()