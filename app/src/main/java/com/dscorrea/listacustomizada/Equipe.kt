package com.dscorrea.listacustomizada

import java.io.Serializable

data class Equipe(var id: Long,
                  var nome: String,
                  val motor: String? = null,
                  val img: String? = null
                   ) : Serializable