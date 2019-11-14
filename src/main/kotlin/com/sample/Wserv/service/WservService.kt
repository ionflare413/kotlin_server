package com.sample.Wserv.service

import com.sample.Wserv.mapper.WservMapper
import com.sample.Wserv.model.WservModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WservService(private val mapper: WservMapper) {

    fun find() : List<WservModel> = mapper.find()

}
