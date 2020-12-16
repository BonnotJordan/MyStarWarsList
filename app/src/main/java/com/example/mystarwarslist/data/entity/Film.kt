package com.example.mystarwarslist.data.entity

import java.util.*

class Film(val title : String, val episode_id : Int, val opening_crawl : String, val director : String, val producer : String, val release_date : Date, val species : Species, val starships : Starships, val vehicles : Vehicles, var characters : Peoples, val planets : Planets, val url : String, val created : String, val edited : String)