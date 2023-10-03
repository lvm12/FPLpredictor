package com.purpleeagle.fplpredictor.viewmodel.viewmodels

import com.purpleeagle.fplpredictor.model.models.bootstrapstatic.BootStrapModel
import com.purpleeagle.fplpredictor.model.models.elementsummary.ElementSummary

sealed interface Events{
    object StartClicked: Events
    data class BootModelGot(val bootStrapModel: BootStrapModel): Events
    data class ElementSumGot(val elementSummary: ElementSummary): Events
}