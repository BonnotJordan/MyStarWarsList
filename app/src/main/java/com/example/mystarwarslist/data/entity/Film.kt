package com.example.mystarwarslist.data.entity

import java.util.*
import kotlin.collections.ArrayList

class Film(val title : String, val episode_id : Int, val opening_crawl : String, val director : String, val producer : String, val release_date : Date, val species : List<String>, val starships : List<String>, val vehicles : List<String>, var characters : List<String>, val planets : List<String>, val url : String, val created : String, val edited : String)