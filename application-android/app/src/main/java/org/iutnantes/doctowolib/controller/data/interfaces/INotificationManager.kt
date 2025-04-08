package org.iutnantes.doctowolib.controller.data.interfaces

import kotlinx.datetime.LocalDateTime



interface INotificationManager {

    fun createNotification(takeMedication : ITakeMedication, date : LocalDateTime )

    fun notifyOk(takeMedication: ITakeMedication, date: LocalDateTime)

}