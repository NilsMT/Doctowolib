package org.iutnantes.doctowolib.database.dto

import kotlinx.serialization.Serializable


@Serializable
data class Medication(
    override val name: String,
    override val id: Int,
    override val dose: Int,
    override val unit: String
) : IMedication {
}