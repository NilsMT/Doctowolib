import pandas as pd

columns_info = {
    "CIS_bdpm": {
        "columns": ["code_cis", "denomination", "forme_pharma", "voie_administration", "statut_admin_amm", "type_procedure_amm", "etat_commer", "date_amm", "statut_bdm", "num_autorisation_euro", "titulaires", "surveillance_renforcee"],
        "drop_columns": ["statut_admin_amm", "type_procedure_amm", "etat_commer", "date_amm", "statut_bdm", "num_autorisation_euro", "titulaires", "surveillance_renforcee"]
    },
    "CIS_CIP_bdpm": {
        "columns": ["code_cis", "code_cip7", "lib_presentation", "statut_admin_presentation", "etat_commerc", "date_declar_commer", "code_cip13", "agrement_collec", "taux_remboursement", "prix_medicament_min", "prix_medicament_max", "difference_prix_min_max", "indication_droit_remboursement"],
        "drop_columns": ["code_cip7", "statut_admin_presentation", "etat_commerc", "date_declar_commer", "agrement_collec", "taux_remboursement", "prix_medicament_min", "prix_medicament_max", "difference_prix_min_max", "indication_droit_remboursement"]
    },
    "CIS_COMPO_bdpm": {
        "columns": ["code_cis", "designation_pharma", "code_substance", "denomination_substance", "dosage_substance", "reference_dosage", "nature_composant", "liaison_sa_ft", "blank"],
        "drop_columns": ["designation_pharma", "code_substance", "nature_composant", "liaison_sa_ft", "blank"]
    }
}

def read_and_merge_data():
    cis_bdpm = pd.read_csv("sources/formated/CIS_bdpm.txt", sep='\t', names=columns_info["CIS_bdpm"]["columns"]).drop(columns=columns_info["CIS_bdpm"]["drop_columns"])
    cis_cip_bdpm = pd.read_csv("sources/formated/CIS_CIP_bdpm.txt", sep='\t', names=columns_info["CIS_CIP_bdpm"]["columns"]).drop(columns=columns_info["CIS_CIP_bdpm"]["drop_columns"])
    cis_composition = pd.read_csv("sources/formated/CIS_COMPO_bdpm.txt", sep='\t', names=columns_info["CIS_COMPO_bdpm"]["columns"]).drop(columns=columns_info["CIS_COMPO_bdpm"]["drop_columns"])

    cis_table = pd.merge(pd.merge(cis_bdpm, cis_cip_bdpm, left_on="code_cis", right_on="code_cis"), cis_composition, left_on="code_cis", right_on="code_cis").dropna()

    return cis_table


def bdpm_to_json(table):
    return table.to_json(path_or_buf="sources/json/cis.json", indent=2)

def main():
    print("Mode test :")
    
    cis_table = read_and_merge_data()
    json_table = bdpm_to_json(cis_table)

if __name__  == "__main__":
    main()