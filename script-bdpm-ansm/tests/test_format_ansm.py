import unittest
import ansm_bdpm_tools.format_ansm as ansm
import tests.ansm_text_samples as text

"""
Test revamp may be necessary using the dictionary trick in :
TestMedications -> test_medications_simple
"""

class TestSeverity(unittest.TestCase):
    
    def test_severity_Basic(self) :
        self.assertEqual(
            "PE",
            ansm.parse_highest_severity(text.severity_simple,False)
        )

    def test_severity_Complex(self) :
        self.assertEqual(
            "CI",
            ansm.parse_highest_severity(text.severity_complex,False)
        )
    
    def test_severity_Random(self) :
        self.assertEqual(
            "CI",
            ansm.parse_highest_severity(text.severity_random,False)
        )
    
    def test_severity_Undefined(self) :
        self.assertEqual(
            "Undefined",
            ansm.parse_highest_severity(text.severity_undefined,False)
        )
    
    def test_severity_Abreviations(self) :
        self.assertEqual(
            "CI",
            ansm.parse_highest_severity("CI - APEC - ASDEC - PE")
        )

class TestIndications(unittest.TestCase) :

    def test_indication_Simple(self) :
        self.assertCountEqual(
            [ansm.ansm_indication("CIMETIDINE","PE")],
            ansm.parse_ansm_indications(text.simple_indication)
        )

    def test_indication_Complex(self) :
        self.assertCountEqual(
            [
                ansm.ansm_indication("CRIZOTINIB","ASDEC"),
                ansm.ansm_indication("IDÉLALISIB","ASDEC"),
                ansm.ansm_indication("INHIBITEURS PUISSANTS DU CYP3A4","APEC")
            ],
            ansm.parse_ansm_indications(text.complex_indication)
        )
    
    def test_indication_Random(self) :
        self.assertCountEqual(
            [
                ansm.ansm_indication("DEXAMETHASONE","PE"),
                ansm.ansm_indication("INDUCTEURS ENZYMATIQUES PUISSANTS","ASDEC"),
                ansm.ansm_indication("RIFAMPICINE","CI"),
            ],
            ansm.parse_ansm_indications(text.random_indication)
        )

class TestMedications(unittest.TestCase) :
    
    def test_eq(self) : # More for coverage rate than anything
        a = ansm.ansm_medication(
            "test_med",
            [ansm.ansm_indication("test_indic","CI")]
        )
        b = ansm.ansm_medication(
            "test_med",
            [ansm.ansm_indication("test_indic","CI")]
        )
        c = ansm.ansm_medication(
            "test_med",
            [ansm.ansm_indication("test_indic2","CI")]
        ) 
        self.assertEqual(a,b)
        self.assertNotEqual(a,c)

    def test_medications_simple(self) :
        expected_dict = {
            "ANTIPARASITAIRES SUSCEPTIBLES DE DONNER DES TORSADES DE POINTES" : [
                ansm.ansm_indication(
                    "SUBSTANCES SUSCEPTIBLES DE DONNER DES TORSADES DE POINTES",
                    "CI"
                )
            ],
            "ANTIPARKINSONIENS ANTICHOLINERGIQUES" : [
                ansm.ansm_indication(
                    "ALCALOÏDES DE L'ERGOT DE SEIGLE DOPAMINERGIQUES",
                    "PE"
                )
            ],
            "ANTIPARKINSONIENS DOPAMINERGIQUES" : [
                ansm.ansm_indication(
                    "NEUROLEPTIQUES ANTIPSYCHOTIQUES (SAUF CLOZAPINE)",
                    "ASDEC"
                )
            ]
        }
        parsed_med_list = ansm.parse_ansm_medication_list(text.simple_medication_list)

        self.assertCountEqual(
            expected_dict.keys(),
            [parsed_med.name for parsed_med in parsed_med_list]
        )

        for parsed_med in parsed_med_list :
            self.assertCountEqual(
                [str(indic) for indic in expected_dict[parsed_med.name]],
                [str(indic) for indic in parsed_med.indications]
            )
    
    def test_medications_complex(self) :
        parsed = ansm.parse_ansm_medication_list(text.complex_medication_list)
        expected = [
                ansm.ansm_medication(
                    "SUNITINIB",
                    [ansm.ansm_indication(
                        "GRAZOPREVIR + ELBASVIR",
                        "ASDEC"
                    )]
                ),
                ansm.ansm_medication(
                    "SUXAMETHONIUM",
                    [ansm.ansm_indication(
                        "ANTICHOLINESTÉRASIQUES",
                        "APEC"
                    )]
                ),
                ansm.ansm_medication(
                    "SYMPATHOMIMÉTIQUES ALPHA (VOIES ORALE ET/OU NASALE)",
                    [ansm.ansm_indication(
                        "ALCALOÏDES DE L'ERGOT DE SEIGLE DOPAMINERGIQUES",
                        "ASDEC"
                    ),ansm.ansm_indication(
                        "ALCALOÏDES DE L'ERGOT DE SEIGLE VASOCONSTRICTEURS",
                        "ASDEC"
                    ),ansm.ansm_indication(
                        "IMAO IRRÉVERSIBLES",
                        "ASDEC"
                    ),ansm.ansm_indication(
                        "SYMPATHOMIMÉTIQUES INDIRECTS",
                        "CI"
                    )]
                ),
                ansm.ansm_medication(
                    "SYMPATHOMIMÉTIQUES ALPHA ET BÊTA (VOIE IM ET IV)",
                    [ansm.ansm_indication(
                        "ANESTHÉSIQUES VOLATILS HALOGÉNÉS",
                        "APEC"
                    ),ansm.ansm_indication(
                        "ANTIDÉPRESSEURS IMIPRAMINIQUES",
                        "ASDEC"
                    ),ansm.ansm_indication(
                        "IMAO IRRÉVERSIBLES",
                        "PE"
                    ),ansm.ansm_indication(
                        "IMAO-A RÉVERSIBLES, Y COMPRIS OXAZOLIDINONES ET BLEU DE MÉTHYLÈNE",
                        "PE"
                    ),ansm.ansm_indication(
                        "MÉDICAMENTS MIXTES ADRÉNERGIQUES-SÉROTONINERGIQUES",
                        "ASDEC"
                    )]
                )
            ]
        self.assertCountEqual(
            [medication.name for medication in expected],
            [medication.name for medication in parsed]
        )
        for i in range(len(expected)) :
            self.assertCountEqual(
                [str(indic) for indic in expected[i].indications],
                [str(indic) for indic in parsed[i].indications]
            )

    def test_medications_random(self) :
        # Beware of leading whitespace (the parser remove them)
        parsed = ansm.parse_ansm_medication_list(text.random_medication_list)
        expected = [
                ansm.ansm_medication(
                    "MÉDICAMENTS SÉDATIFS",
                    [ansm.ansm_indication(
                        "AUTRES MÉDICAMENTS SÉDATIFS",
                        "CI"
                    ),ansm.ansm_indication(
                        "ALCOOL (BOISSON OU EXCIPIENT)",
                        "ASDEC"
                    )]
                ),
                ansm.ansm_medication(
                    "MÉDICAMENTS, BRADYKININE ET ANGIO-ŒDÈME",
                    [ansm.ansm_indication(
                        "AUTRES MEDICAMENTS À RISQUE D'ANGIO-ŒDÈME",
                        "CI"
                    )]
                ),
                ansm.ansm_medication(
                    "MEFLOQUINE",
                    [ansm.ansm_indication(
                        "QUININE",
                        "ASDEC"
                    )]
                )
            ]
        self.assertCountEqual(expected,parsed)

if __name__ == '__main__':
    unittest.main() # pragma: no cover