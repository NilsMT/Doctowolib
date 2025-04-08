# Données à sélectionner pour la création de la base MongoDB selon les features.


## CIS_bpdm => OK

 - [X] Code CIS
 - [X] Dénomination du médicament
 - [X] Forme pharmaceutique
 - [X] Voies d'administration
 - [ ] Statut administratif de l’AMM
 - [ ] Type de procédure d'AMM
 - [ ] Etat de commercialisation
 - [ ] Date d’AMM (format JJ/MM/AAAA)
 - [ ] StatutBdm : «Alerte»/ «disponibilité »
 - [ ] Numéro de l’autorisation européenne
 - [ ] Titulaire(s)
 - [ ] Surveillance renforcée (triangle noir) Oui/Non

## CIS_compo_bpdm => OK

 - [X] Code CIS
 - [ ] Désignation de l'élément pharmaceutique
 - [ ] Code de la substance
 - [X] Dénomination de la substance
 - [X] Dosage de la substance
 - [X] Référence de ce dosage
 - [ ] Nature du composant
 - [ ] Numéro de liaison SA/FT

## CIS_infoimportante => NOK

- [ ] Code_CIS
- [ ] Texte à afficher et lien vers l'info de sécurité

## CIS_CIP_bpdm => OK

 - [X] Code CIS
 - [ ] Code CIP7
 - [X] Libellé de la présentation
 - [ ] Statut administratif de la présentation
 - [ ] Etat de commercialisation
 - [ ] Date de la déclaration de commercialisation
 - [X] Code CIP13
 - [ ] Agrément aux collectivités
 - [ ] Taux de remboursement
 - [ ] Prix du médicament en euro
 - [ ] Indications ouvrant droit au remboursement

## CIS_CIP_Dispo_Spec => NOK

 - [ ] Code CIS
 - [ ] Code CIP13
 - [ ] CodeStatut
 - [ ] Statut
 - [ ] DateDebut
 - [ ] DateMiseAJour
 - [ ] DateRemiseDispo
 - [ ] Lien vers la page du site ANSM

## CIS_CPD_bpdm => NOK

 - [ ] Code CIS
 - [ ] Condition de prescription ou de délivrance ( Par exemple, réservé aux prescriptions de soins dentaires)

## CIS_HAS_ASMR => NOK

 - [ ] Code CIS
 - [ ] Code de dossier HAS
 - [ ] Motif d’évaluation
 - [ ] Date de l’avis de la Commission de la transparence
 - [ ] Valeur de l'ASMR
 - [ ] Libelle de l'ASMR

## CIS_HAS_SMR => NOK

 - [ ] Code CIS
 - [ ] Code de dossier HAS
 - [ ] Motif d’évaluation
 - [ ] Date de l’avis de la Commission de la transparence
 - [ ] Valeur du SMR
 - [ ] Libelle du SMR

## HAS_LiensPageCT_bpdm => NOK

 - [ ] Code de dossier HAS
 - [ ] Lien vers les pages d’avis de la CT

 ## CIS_GENER_bdpm => NOK

 - [ ] Identifiant du groupe générique
 - [ ] Libellé du groupe générique
 - [ ] Code CIS
 - [ ] Type de générique
 - [ ] Numéro de tri