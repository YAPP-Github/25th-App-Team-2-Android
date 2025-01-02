package co.kr.tnt.data.source

import co.kr.tnt.data.service.TnTService
import javax.inject.Inject

@Suppress("UnusedPrivateProperty")
internal class TnTDataSource @Inject constructor(
    private val tntService: TnTService,
)
