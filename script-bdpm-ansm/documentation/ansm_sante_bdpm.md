# Représentation des données importante dans les différents fichiers

## CIS_bpdm

ID du produit

Nom du produit

Forme de consommation (genre gélule comprimé etc...)

Façon de le consommer (voie orale, rectale, intraveineuse etc...)

Administratif (potentiellement inutile)

Administratif (inutile aussi)

Type de commercialisation

Date de création (inutile)

Disponibilité ? (inutile)

Autorisation européenne ?

Titulaires (en gros le médicament appartient à qui)

Surveillance renforcée ? (je ne sais pas trop ce que c'est) (triangle noir)

## CIS_compo_bpdm 

Overall donne toutes les informations précise à un médicament, possible de récupérer les informations du médicament comme le nom depuis CIS_bpdm

ID du produit

Forme de consommation (genre gélule comprimé etc...)

code de la substance ? (imo inutile)

nom de la substance principale

dose de la substance principale

Référence du dosage (inutile)

Nature du composant (inutile)

Numéro de liaison (inutile)

## CIS_GENER_bpdm 

à l'air inutile

ID du groupe produit (inutile ptet)

Description du groupe produit

ID du produit

Type de générique ?

Numéro de tri ?

## CIS_CIP_Dispo_Spec

Donne la spécification d'un produit en rupture de stock ou non, si oui donne aussi la date de réapprovisionnement ainsi qu'un lien vers le site de l'ansm santé

ID du produit

Numéro correpondant à l'état du produit

Nom spécifiant l'état du produit

Date d'approvisionnement à la base

Date de mise à jour du produit ? (je n'ai pascompris)

Date de réapprovisionnement

Lien vers L'ansm du produit

## CIS_infoimportante

Donne les informations par rapport aux danger/mauvaise utilisation d'un produit/alternative etc....
en gros ptet inutile

Id du produit

Date de création de la page

Date de péremption de la page

Lien vers la page de "sensibilisation"


## CIS_CIP_bpdm

Donne la descritpions des éléments du produit (pas intérieur mais descirptif genre prix remboursement ect........)

ID du produit

CIP7 ?

Libellé

Présentation activé (jsp inutile)

Déclaration nanani nanana (inutile)

Date de commercialisation (inutile nn ?)

Numéro de produit (genre celui qui correspond au code bar des produits (surement utile à garder je trouve))

Agrément aux collectivité ? (inutilen e vrai)

Taux de remboursmeent

Prix

Description (très peu affichée donc inutile)


## CIS_CPD_bpdm

Donne l'usage du produit (a l'air inutile nn ? ou ptet que si pour trier les iformatios)

ID du produit

Informations du l'usage du produit (genre hospitalier, dentaire etc....)

## CIS_HAS_ASMR

Donne spécificité par rapport à un produit + lien vers une page de description (ID HAS)

ID Du produit

code HAS

jsp

date de création de la description

valeur ? 

Autre description type html (description plus précise du médicament)

## CIS_HAS_SMR  

Donne les spécificités de comment le fournisseur décrit le produit avec une valeur ?

ID Du produit

code HAS

date de l'avis (inutile)

valeur (jsp sert ptet a rien ou très utile à voir)

Libelle (description)


## HAS_LiensPageCT_bpdm

Fait le lien entre l'ID HAS et la page correspondante

Code HAS

Lien vers la page has-sante.fr/jcms/etc....
