import requests
import re

# Liste de fichier à récupèrer dans la BDPM
files_bdpm = [
    "CIS_bdpm.txt",
    "CIS_CIP_bdpm.txt",
#   "CIS_CIP_Dispo_Spec.txt",
    "CIS_COMPO_bdpm.txt",
#   "CIS_CPD_bdpm.txt",
#   "CIS_GENER_bdpm.txt",
#   "CIS_HAS_ASMR_bdpm.txt",
#   "CIS_HAS_SMR_bdpm.txt",
#   "HAS_LiensPageCT_bdpm.txt",
#   "CIS_InfoImportantes.txt"
]

def fetch_bdpm(target_path: str):
    root_url = "https://base-donnees-publique.medicaments.gouv.fr/telechargement.php"
    print("Téléchargement des données de la BDPM :")
    for filename in files_bdpm:
        print("-> "+filename)
        filepath = re.sub(r"(\/$)|(?<!\/)$","/",target_path)+filename
        # Télécharge le fichier et l'enregistre :targetpath
        with open(filepath,"wb") as file :
            rep = requests.get(root_url+"?fichier="+filename)
            rep.raise_for_status()
            file.write(rep.content) 

def fetch_ansm(path: str) :
    print("Téléchargement données de l'ANSM :")
    root_url = "https://ansm.sante.fr"
    # Request the HTML to find the download link
    rep = requests.get( root_url+"/documents/reference/thesaurus-des-interactions-medicamenteuses-1")
    rep.raise_for_status()
    # Match the PDF name in the HTML :
    regex_pdf = re.compile(
        r"(?<=\<a href=\")\/uploads(\/\d+)*-thesaurus-interactions-medicamenteuses-\w+-\d{4}\.pdf(?=\".*\>)"
    )
    pdf_url = re.search(regex_pdf,rep.text).group(0)
    # Fetch the PDF and write it by chunk to avoid memory issues
    with requests.get(root_url+pdf_url, stream=True) as r:
        r.raise_for_status()
        # Regex garantisant que le chemin fini par un /
        filepath = re.sub(r"(\/$)|(?<!\/)$","/",path)+'thesaurus-interactions-medicamenteuses.pdf'
        with open(filepath, 'wb') as f:
            for chunk in r.iter_content(chunk_size=8192):
                f.write(chunk)
    print("-> thesaurus-interactions-medicamenteuses.pdf")


def fetch_sources(path: str) :
    fetch_bdpm(path)
    fetch_ansm(path)

def main():
    print("Mode test :")
    fetch_sources('sources/raws')

if __name__ == "__main__":
    main()
