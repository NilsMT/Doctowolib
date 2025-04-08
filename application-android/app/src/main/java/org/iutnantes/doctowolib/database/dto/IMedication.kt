package org.iutnantes.doctowolib.database.dto


/**
 *
 *  Interface pour les médicaments
 *
 *  @property name du médicament
 *  @property id Id du médicament dans la base de donnée et la BDPM
 *  @property dose Dosage du traitement
 *  @property unit Unité du médicament (mg, g, ml, ampoule etc...)
 *  
 *  
 *
 * @author Luna Manson
 *
 */
interface IMedication {

    val name : String
    val id : Int
    val dose : Int
    val unit : String

}