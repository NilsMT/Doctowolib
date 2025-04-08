# DoctOwOlib - Application Android
DoctOwOlib est une application mobile développée dans le cadre d'un projet étudiant dont l'objectif est d'assurer un suivi des différentes prescriptions médicamenteuses.

## Comment build l'application
L'application n'ayant pas été publiée, l'installation se fait localement depuis ce dépot.

```
# Ouvrir un terminal (Command Prompt or PowerShell  Windows, Terminal for macOS or Linux)

# Assurer vous que git est installé 
# Visiter https://git-scm.com pour télécharger et installer la console git si elle ne l'est pas déjà

# cloner le dépôt
git clone https://gitlab.univ-nantes.fr/sae6-2425-doctowolib-initiaux/application-android.git
```

* Assurez vous d'avoir android studio d'installé 
* Assurer vous d'avoir un SDK android (celui utilisé par l'application étant de version 34)
* Lancer android studio et ouvrir le dépôt local

[Android studio ](https://developer.android.com/studio?hl=fr).

Elle dépend cependant d'autres projets/librairies que vous pouvez trouver [ici](https://gitlab.univ-nantes.fr/sae6-2425-doctowolib-initiaux).

## Fonctionnalités
### L’application identifie et caractérise la maladie du patient
* L’application peut scanner une ordonnance et reconnaître les médicaments prescrits
* L’application peut enregistrer les informations d’un traitement que le patient suit en plus de celui de son ordonnance
* L’application enregistre localement les informations personnelles du patient, notamment ses allergies
* L’application est capable d’avertir l’utilisateur sur des problèmes de compatibilité entre des médicaments, des allergènes présents dans des médicaments et sur des risques secondaires

### L’application assure un suivi rigoureux et intuitif du traitement du patient
* L’application enregistre la fréquence de la prise des médicaments et notifie l’utilisateur à chaque fois qu’il doit prendre un médicament
* L’application donne des conseils thérapeutiques au patient et le renseigne sur sa maladie
* L’application s’adapte à son utilisateur, que cela soit à son âge ou à un potentiel handicap lié à sa maladie


## Utilisation
### Permissions 
Pour fonctionner, l'application requiert : 
* L'accès à l'appareil photo
* L'accès aux fichiers 
Ce dans le but de scanner les ordonnances. 


## Structures de données utilisées
**Fréquences (IFrequencies) ** : 
- daysBetweenTakes : Int 
- minimumTimeBetweenTakes : Int ?
- intakeTimes : Array<LocalDateTime> ?
- isNeeded : Boolean

**Paramètres (IParameters) ** :
- morningTime : LocalTime
- noonTime : LocalTime
- eveningTime : LocalTime 

**Ordonnances (IPrescriptions)** : 
- id : Int
- renewable : Boolean
- startDate: LocalDate
- renewalPeriod : LocalDate
- treatments : Array<ITreatment>

**Traitement(Treatment)**
- frequency : IFrequencies
- dosage : Pair<Int,String>
- endDate : LocalDate
- medication : IMedication

**Médicament (Medication)**
- name : String
- id : Int
- dose : Int
- unit : String

**Patient** : 
- age : Int
- weight : Int
- allergies : Array<String>

## Retours et contributions
Voir [CONTRIBUTING.md](https://gitlab.univ-nantes.fr/sae6-2425-doctowolib-initiaux/application-android/-/blob/main/CONTRIBUTING.md?ref_type=heads)

## License
Voir [LICENCE.md](https://gitlab.univ-nantes.fr/sae6-2425-doctowolib-initiaux/application-android/-/blob/main/LICENCE.md?ref_type=heads)