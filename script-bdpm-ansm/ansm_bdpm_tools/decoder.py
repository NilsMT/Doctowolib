import os
import codecs
import re
from pypdf import PdfReader

# Windows1252 = cp1252
EncodingList = {
    "CIS_bdpm.txt": "iso-8859-1",
    "CIS_CIP_bdpm.txt": "cp1252",
    "CIS_CIP_Dispo_Spec.txt": "cp1252",
    "CIS_COMPO_bdpm.txt": "iso-8859-1",
    "CIS_CPD_bdpm.txt": "cp1252",
    "CIS_GENER_bdpm.txt": "cp1252",
    "CIS_HAS_ASMR_bdpm.txt": "cp1252",
    "CIS_HAS_SMR_bdpm.txt": "cp1252",
    "CIS_InfoImportantes.txt": "iso-8859-1",
    "HAS_LiensPageCT_bdpm.txt": "iso-8859-1",
}

def format_bdpm_to_UTF8(sourcepath: str,encoding: str,targetpath):
    print(sourcepath+" ("+encoding+") -> "+targetpath)
    BLOCKSIZE = 1048576 # Read 1Mib at a time
    with codecs.open(sourcepath, "r",encoding) as sourceFile:
        with codecs.open(targetpath, "w", "utf-8") as targetFile:
            while True:
                data = sourceFile.read(BLOCKSIZE)
                if not data : 
                    break
                targetFile.write(data)

def format_ansm_pdf_to_text(pdf_path: str,target_path: str) -> str :
    print(pdf_path+" -> "+target_path)
    reader = PdfReader(pdf_path)
    pdf_text = ""
    for page in reader.pages[2:] :
        pdf_text += page.extract_text()
    pdf_text = re.sub(r"^2\n","",pdf_text) # Supprime le n° de page
    with open(target_path,"w") as file :
        file.write(pdf_text)

def format_dir(source_directory: str,output_directory):
    print("Convertion des sources de "+source_directory+" en UTF-8 :")
    out_dir = re.sub(r"(\/$)|(?<!\/)$","/",output_directory)
    for entry in os.scandir(source_directory):
        if entry.name[-4:] == ".txt": # Convert text files
            # Standardize le nom du fichier en retirant les dates du nom
            std_filename = re.sub(r"_\d+","",entry.name)
            format_bdpm_to_UTF8(
                sourcepath=entry.path,
                encoding=EncodingList[std_filename],
                # Donne le chemin vers le nouveau fichier en ajoutant un / si nécéssaire
                targetpath=out_dir+"BDPM_"+re.sub(r"_bdpm(?=.txt)"," ",std_filename)
            )
        elif entry.name[-4:] == ".pdf" :
            format_ansm_pdf_to_text(
                pdf_path=entry.path,
                target_path=out_dir+re.sub(r"\.pdf$",".txt",entry.name)
            )

def main() :
    print("Mode test :")
    format_dir("sources/raws","sources/formated")

if __name__  == "__main__":
    main()