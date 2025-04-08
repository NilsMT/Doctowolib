severity_undefined = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit,
sed do eiusmod tempor incididunt ut labore et dolore magnam aliquam quaerat voluptatem. 
"""

severity_simple = """
Précaution d'emploi
Réduire la posologie de l’abrocitinib de moitié en cas de traitement par 
la fluvoxamine.Risque de majoration des effets indésirables de l’abrocitinib par 
diminution de son métabolisme."""

severity_complex = """
CI - ASDEC - APEC
Contre-indication avec :
- des doses anti-inflammatoires d'acide acétylsalicylique (>=1g par prise 
et/ou >=3g par jour)
- des doses antalgiques ou antipyrétiques (>=500 mg par prise et/ou 
<3g par jour) et en cas d’antécédent d’ulcère gastro-duodénal
Association déconseillée avec :
- des doses antalgiques ou antipyrétiques (>=500 mg par prise et/ou 
<3g par jour) en l'absence d’antécédent d’ulcère gastro-duodénal
- des doses antiagrégantes (de 50 mg à 375 mg par jour) et en cas 
d’antécédent d’ulcère gastro-duodénal. Nécessité d'un contrôle le cas 
échéant, en particulier du temps de saignement.
A prendre en compte avec :
- des doses antiagrégantes (de 50 mg à 375 mg par jour)Majoration du risque hémorragique, notamment en cas 
d’antécédent d’ulcère gastro-duodénal."""

severity_random = """
CI - ASDEC
Contre-indication:
- Pour l'érythromycine et la vincamine, seules les formes administrées 
par voie intraveineuse sont concernées par cette interaction.
- Pour la spiramycine, la voie IV et la voie orale sont concernées.
- Le citalopram, l'escitalopram, l'hydroxyzine, la dompéridone, la 
pipéraquinei sont contre-indiqués quel que soit le torsadogène.
Association déconseillée:
- avec les antiparasitaires (chloroquine, halofantrine, luméfantrine, 
pentamidine), les neuroleptiques, la méthadone, l'arsénieux et 
l'hydroxychloroquine.
Si l’association ne peut être évitée, contrôle clinique et 
électrocardiographique régulier.Risque majoré de troubles du rythme ventriculaire, notamment de 
torsades de pointes.
"""

simple_indication = """
Voir aussi : benzodiazépines et apparentés - médicaments sédatifs

+CIMETIDINE
Précaution d'emploi
Avertir les patients de l'augmentation du risque en cas de conduite 
automobile ou d'utilisation de machines.Avec la cimétidine utilisée à des doses supérieures ou égales à 
800 mg/j : risque accru de somnolence."""

complex_indication = """
Ils sont principalement représentés par le rivaroxaban et l'apixaban, le ticagrélor, la simvastatine et l'atorvastatine, les immunosuppresseurs, le pimozide, la quétiapine, 
le midazolam, les inhibiteurs de tyrosine kinase métabolisés, les vinca-alcaloïdes cytotoxiques, les taxanes, l'ergotamine, certains opiacés (alfentanil, sufentanil, 
oxycodone), l'halofantrine et la luméfantrine, la quinine.
Pour connaître les risques et les niveaux de contrainte de chacun de ces substrats avec les inhibiteurs puissants du CYP3A4, il convient de se reporter aux 
interactions spécifiques de chaque substrat.
(abémaciclib, alfentanil, apixaban, atorvastatine, axitinib, bortezomib, bosutinib, brigatinib, cabazitaxel, cabozantinib, céritinib, ciclosporine, cobimétinib, crizotinib, 
dabrafénib, dasatinib, dihydroergotamine, docetaxel, ergotamine, erlotinib, everolimus, gefitinib, halofantrine, ibrutinib, imatinib, irinotecan, lapatinib, lorlatinib, 
lumefantrine, midazolam, nilotinib, osimertinib, oxycodone, paclitaxel, palbociclib, pazopanib, pimozide, ponatinib, quetiapine, quinine, rivaroxaban, ruxolitinib, 
simvastatine, sirolimus, sorafenib, sufentanil, sunitinib, tacrolimus, temsirolimus, ticagrelor, vandétanib, vinblastine, vincristine, vindesine, vinflunine, vinorelbine)
+CRIZOTINIB
Association DECONSEILLEE Risque de majoration de la toxicité de ces molécules par diminution 
de leur métabolisme et/ou augmentation de leur biodisponibilité par 
le crizotinib.230
+IDÉLALISIB
Association DECONSEILLEE Augmentation des concentrations plasmatiques du substrat par 
diminution de son métabolisme hépatique par l’idelalisib.
+INHIBITEURS PUISSANTS DU CYP3A4
A prendre en compte Majoration des effets indésirables propres à chaque substrat, avec 
conséquences souvent sévères."""

random_indication = """
+DEXAMETHASONE
Précaution d'emploi
Décaler l'administration des deux médicaments d'au moins une 
semaine.Diminution des concentrations plasmatiques du praziquantel, avec 
risque d'échec du traitement, par augmentation du métabolisme 
hépatique du praziquantel par la dexaméthasone.
+INDUCTEURS ENZYMATIQUES PUISSANTS
Association DECONSEILLEE Diminution très importante des concentrations plasmatiques du 
praziquantel, avec risque d'échec du traitement, par augmentation 
de son métabolisme hépatique par l'inducteur.
+RIFAMPICINE
CONTRE-INDICATION Diminution très importante des concentrations plasmatiques du 
praziquantel, avec risque d'échec du traitement, par augmentation 
du métabolisme hépatique du praziquantel par la rifampicine."""


simple_medication_list="""
ANTIPARASITAIRES SUSCEPTIBLES DE DONNER DES TORSADES DE POINTES
(chloroquine, halofantrine, lumefantrine, pentamidine, pipéraquine)
+SUBSTANCES SUSCEPTIBLES DE DONNER DES TORSADES DE POINTES
CI - ASDEC
Contre-indication:
- avec le citalopram, la dompéridone, l'escitalopram, l'hydroxyzine
et la pipéraquine.
Association déconseillée:
- avec les autres médicaments susceptibles de donner des torsades de 
pointes.
Si cela est possible, interrompre l'un des deux traitements. Si 
l'association ne peut être évitée, contrôle préalable du QT et 
surveillance ECG monitorée.Risque majoré de troubles du rythme ventriculaire, notamment de 
torsades de pointes.
ANTIPARKINSONIENS ANTICHOLINERGIQUES
(biperidene, trihexyphenidyle, tropatepine)
+ALCALOÏDES DE L'ERGOT DE SEIGLE DOPAMINERGIQUES
Précaution d'emploi
Surveillance clinique et biologique régulière, notamment en début 
d'association.Risque de majoration des troubles neuropsychiques.
ANTIPARKINSONIENS DOPAMINERGIQUES
(amantadine, apomorphine, bromocriptine, entacapone, lisuride, piribedil, pramipexole, rasagiline, ropinirole, rotigotine, selegiline, tolcapone)
+NEUROLEPTIQUES ANTIPSYCHOTIQUES (SAUF CLOZAPINE)
Association DECONSEILLEE Antagonisme réciproque du dopaminergique et des neuroleptiques. 
Le dopaminergique peut provoquer ou aggraver les troubles 
psychotiques. En cas de nécessité d'un traitement par 
neuroleptiques chez le patient parkinsonien traité par 
dopaminergique, ces derniers doivent être diminués 
progressivement jusqu'à l'arrêt (leur arrêt brutal expose à un risque 
de "syndrome malin des neuroleptiques")."""


complex_medication_list = """
SUNITINIB
Voir aussi : inhibiteurs de tyrosine kinases métabolisés - substrats à risque du CYP3A4
+GRAZOPREVIR + ELBASVIR
Association DECONSEILLEE
Si l’association ne peut être évitée, surveillance clinique étroite.Risque d’augmentation des effets indésirables du sunitinib par le 
grazoprévir/elbasvir.
SUXAMETHONIUM
Voir aussi : curares
+ANTICHOLINESTÉRASIQUES
A prendre en compte Risque d'allongement du bloc moteur, majoré en cas de déficit 
partiel en pseudocholinestérase.
SYMPATHOMIMÉTIQUES ALPHA (VOIES ORALE ET/OU NASALE)
(etilefrine, midodrine, naphazoline, oxymetazoline, phenylephrine, synephrine, tetryzoline, tuaminoheptane)
+ALCALOÏDES DE L'ERGOT DE SEIGLE DOPAMINERGIQUES
Association DECONSEILLEE Risque de vasoconstriction et/ou de poussées hypertensives.
+ALCALOÏDES DE L'ERGOT DE SEIGLE VASOCONSTRICTEURS
Association DECONSEILLEE Risque de vasoconstriction et/ou de poussées hypertensives.
+IMAO IRRÉVERSIBLES
Association DECONSEILLEE Crises hypertensives (inhibition du métabolisme des amines 
pressives). Du fait de la durée d'action de l'IMAO, cette interaction 
est encore possible 15 jours après l'arrêt de l'IMAO.
+SYMPATHOMIMÉTIQUES INDIRECTS
CONTRE-INDICATION Risque de vasoconstriction et/ou de poussées hypertensives.
SYMPATHOMIMÉTIQUES ALPHA ET BÊTA (VOIE IM ET IV)
(adrenaline, dopamine, noradrenaline, norepinephrine)
+ANESTHÉSIQUES VOLATILS HALOGÉNÉS
A prendre en compte Décrit avec l'halothane et le cyclopropane.
Troubles du rythme ventriculaire graves par augmentation de 
l'excitabilité cardiaque.
+ANTIDÉPRESSEURS IMIPRAMINIQUES
Association DECONSEILLEE Hypertension paroxystique avec possibilité de troubles du rythme 
(inhibition de l'entrée du sympathomimétique dans la fibre 
sympathique).
+IMAO IRRÉVERSIBLES
Précaution d'emploi
A n'utiliser que sous contrôle médical strict.Augmentation de l'action pressive du sympathomimétique, le plus 
souvent modérée.
+IMAO-A RÉVERSIBLES, Y COMPRIS OXAZOLIDINONES ET BLEU DE MÉTHYLÈNE
Précaution d'emploi
A n'utiliser que sous contrôle médical strict.Par extrapolation à partir des IMAO non sélectifs : risque 
d'augmentation de l'action pressive.
+MÉDICAMENTS MIXTES ADRÉNERGIQUES-SÉROTONINERGIQUES
Association DECONSEILLEE Hypertension paroxystique avec possibilité de troubles du rythme 
(inhibition de l'entrée du sympathomimétique dans la fibre 
sympathique)."""

random_medication_list = """
MÉDICAMENTS SÉDATIFS
Il faut prendre en compte le fait que de nombreux médicaments ou substances peuvent additionner leurs effets dépresseurs du système nerveux central et contribuer à 
diminuer la vigilance. Il s'agit des dérivés morphiniques (analgésiques, antitussifs et traitements de substitution), des neuroleptiques, des barbituriques, des 
benzodiazépines, des anxiolytiques autres que les benzodiazépines (par exemple, le méprobamate), des hypnotiques, des antidépresseurs sédatifs (amitriptyline, 
doxépine, miansérine, mirtazapine, trimipramine), des antihistaminiques H1 sédatifs, des antihypertenseurs centraux, du baclofène et du thalidomide.
(agomelatine, alfentanil, alimemazine, alizapride, alprazolam, amisulpride, amitriptyline, aripiprazole, avizafone, azelastine, baclofene, bromazepam, brompheniramine, 
buprenorphine, captodiame, cénobamate, chlordiazepoxide, chlorphenamine, chlorpromazine, clobazam, clonazepam, clonidine, clorazepate, clotiazepam, clozapine, 
codeine, cyamemazine, cyproheptadine, dapoxétine, dexchlorpheniramine, dexmédétomidine, dextromethorphane, di(acefylline) diphenhydramine, diazepam, 
dihydrocodeine, dimenhydrinate, diphenhydramine, doxepine, doxylamine, droperidol, eskétamine, estazolam, eszopiclone, ethylmorphine, etifoxine, fenspiride, 
fentanyl, flunarizine, flupentixol, fluphenazine, flurazepam, gabapentine, haloperidol, hydromorphone, hydroxyzine, isothipendyl, ketotifene, levomepromazine, 
loflazépate, loprazolam, lorazepam, lormetazepam, loxapine, maprotiline, méclozine, mepyramine, mequitazine, methadone, methyldopa, metoclopramide, 
metopimazine, mianserine, midazolam, mirtazapine, morphine, moxonidine, nalbuphine, naloxone, nefopam, nitrazepam, nordazepam, noscapine, olanzapine, 
oxazepam, oxetorone, oxomemazine, oxybate de sodium, oxycodone, paliperidone, penfluridol, pérampanel, pethidine, pheniramine, phenobarbital, phenyltoloxamine, 
pholcodine, pimethixene, pimozide, pipamperone, pipotiazine, pizotifene, prazepam, pregabaline, primidone, promethazine, propericiazine, quetiapine, remifentanil, 
rilmenidine, risperidone, ropinirole, rupatadine, sodium (oxybate de), sufentanil, sulpiride, tapentadol, tetrabenazine, thalidomide, tiapride, tramadol, trimipramine, 
triprolidine, ziconotide, zolpidem, zopiclone, zuclopenthixol)
+ AUTRES MÉDICAMENTS SÉDATIFS
CI - ASDEC - APEC
A prendre en compte:
- pour tous les médicaments sédatifs entre eux sauf:
- avec l'oxybate de sodium (association déconseillée)
- entre l'oxybate de sodium et les opiacés ou les barbituriques  (contre-
indication)Majoration de la dépression centrale.
L'altération de la vigilance peut rendre dangereuses la conduite de 
véhicules et l'utilisation de machines.
+ALCOOL (BOISSON OU EXCIPIENT)
Association DECONSEILLEE
Eviter la prise de boissons alcoolisées et de médicaments contenant de 
l'alcool.Majoration par l'alcool de l'effet sédatif de ces substances. 
L'altération de la vigilance peut rendre dangereuses la conduite de 
véhicules et l'utilisation de machines.
MÉDICAMENTS, BRADYKININE ET ANGIO-ŒDÈME
Certains médicaments ou classes thérapeutiques sont susceptibles de provoquer une réaction vasculaire à type d’angio-œdème de la face et du cou, résultant de 
l’inhibition de la dégradation de la bradykinine. Les médicaments les plus fréquemment impliqués sont les IEC, certains immunosuppresseurs dits mTORi, un 
antidiarrhéique, le racécadotril, un cytotoxique, l’estramustine, le sacubitril. Les antidiabétiques de la classe des gliptines ont été impliqués dans une étude isolée. Les 
conséquences de l’angio-oedème peuvent parfois être fatales, par obstruction des voies respiratoires. L’angio-oedème peut survenir indépendamment d’une 
association simultanée entre ces médicaments, au cas où le patient aurait été exposé antérieurement à l’un des deux protagonistes. Il conviendra de rechercher des 
antécédents de survenue de cet effet et de mesurer la nécessité de ce type d’association.
(alteplase recombinante, azilsartan, benazepril, candesartan cilexetil, captopril, cilazapril, enalapril, eprosartan, estramustine, évérolimus, fosinopril, irbesartan, 
linagliptine, lisinopril, losartan, moexipril, olmesartan, périndopril, quinapril, racecadotril, ramipril, sacubitril, saxagliptine, sirolimus, sitagliptine, telmisartan, 
temsirolimus, trandolapril, valsartan, vildagliptine, zofenopril)
+ AUTRES MEDICAMENTS À RISQUE D'ANGIO-ŒDÈME
CI - ASDEC - APEC
Contre-indication : 
- entre sacubitril et IEC
A prendre en compte :
- entre gliptines et IEC
Déconseillé entre les autresRisque de majoration de la survenue d'un angio-œdème d'origine 
bradykinique, pouvant être fatal.
MEFLOQUINE
Voir aussi : bradycardisants - médicaments abaissant le seuil épileptogène
+QUININE
Association DECONSEILLEE
Respecter un délai minimum de 12 heures entre la fin de 
l'administration IV de quinine et le début de l'administration de 
méfloquine.Pour la quinine administrée par voie IV : risque majoré de survenue 
de crises épileptiques par addition des effets proconvulsivants."""