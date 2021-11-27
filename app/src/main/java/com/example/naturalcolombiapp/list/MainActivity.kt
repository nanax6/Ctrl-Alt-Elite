package com.example.naturalcolombiapp.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naturalcolombiapp.R
import com.example.naturalcolombiapp.detail.DetailActivity
import com.example.naturalcolombiapp.model.Parques
import com.example.naturalcolombiapp.model.ParquesItem
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var listaParques: ArrayList<ParquesItem>
    private lateinit var parquesAdapter: ParquesAdapter
    private lateinit var parquesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parquesRecyclerView = findViewById(R.id.lista_parques_recyclerview)

        // listaParques = createMockParques()

        listaParques = cargaListaJson ()
        parquesAdapter = ParquesAdapter(listaParques, onItemClicked = { onMainActivityClicked(it) })

        parquesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = parquesAdapter
            setHasFixedSize(false)
        }

        parquesRecyclerView.adapter = parquesAdapter
    }

    private fun onMainActivityClicked(parques: ParquesItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("parques", parques)
        startActivity(intent)

    }

    private fun cargaListaJson(): ArrayList<ParquesItem> {
        val parquesString: String = applicationContext.assets.open("parques.json").bufferedReader().use{ it.readText() }
        val gson = Gson()
        val datos = gson.fromJson(parquesString, Parques::class.java)
        return datos
    }

    /*private fun createMockParques(): ArrayList<Parques> {
        return arrayListOf(
            Parques(
                parqueNacional = "Parque Nacional Natural\n Serranía de Chiribiquete",
                descripcion = "El Parque Nacional de Chiribiquete destaca no solo por su\n impresionante extensión de casi 3 millones de hectáreas,\n sino también por su rica biodiversidad.\n El parque posee la fauna representativa en el área\n amazónica, tales como el jaguar, el tapir y el águila arpía,\n entre otros.",
                puntuacion = 4.5,
                foto = "https://lanotapositiva.com/wp-content/uploads/2015/05/parque.jpg"
            ),

            Parques(
                parqueNacional = "Parque Nacional Natural El Cocuy",
                descripcion = "Es la mayor masa glaciar de Colombia conformada por\n más de 25 picos cubiertos de hielo y nieve, en dos cadenas montañosas de aproximadamente 25 kilómetros de longitud por 4 de ancho.",
                puntuacion = 4.4,
                foto = "https://colombiapais.com/pagina-parques-nacionales-naturales/imagenes/parque-nacional-natural-el-cocuy-sierra.jpg"
            ),

            Parques(
                parqueNacional = "Parque Nacional Natural Los Katíos",
                descripcion = "Los paisajes del Parque los Katíos presentan gran variedad y belleza. Las estribaciones de la Serranía del Darién forman montañas y colinas al norte y centro del área protegida. En estos sectores hay grandes caídas y saltos de agua de imponente hermosura como El Tilupo con cerca de 100 metros de cascada.",
                puntuacion = 4.0,
                foto = "https://static.wixstatic.com/media/877a15_58364df8fbcf431d90e44648b280ddb3.jpg/v1/fill/w_640,h_424,al_c,q_90/877a15_58364df8fbcf431d90e44648b280ddb3.jpg"
            ),

            Parques(
                parqueNacional = "Parque Nacional Natural Los Nevados",
                descripcion = "El Parque Nacional Natural Los Nevados se localiza en el corazón del Eje Cafetero, en el complejo volcánico norte conformado por el  volcán Nevado del Ruíz, cráteres La Olleta y La Piraña, el volcán Nevado de Santa Isabel, el volcán Nevado del Tolima, y los Paramillos del Cisne, Santa Rosa y Quindío.",
                puntuacion = 5.0,
                foto = "https://colombiapais.com/pagina-parques-nacionales-naturales/imagenes/parque-natural-nevados-quindio-colombia.jpg"
            ),

            Parques(
                parqueNacional = "Parque Nacional Natural Sumapaz",
                descripcion = "El Parque Nacional Natural Sumapaz es uno de los sitios de alta montaña más rico en géneros y especies de flora colombiana, ya que posee un gran número de organismos, muchos de ellos endémicos que hacen del Parque un reservorio importante de diversidad biológica, ecológica y genética.",
                puntuacion = 4.5,
                foto = "https://bogotadc.travel/drpl/sites/default/files/2020-10/sumapaz-1.jpg"
            ),

            Parques(
                parqueNacional = "Parque Nacional Natural Tayrona",
                descripcion = "Para quienes buscan la contemplación y el descanso, el Parque ofrece magníficas playas y el relajante panorama de un mar intensamente azul. Quienes se sienten atraídos por actividades más emocionantes podrán disfrutar de caminatas, careteo y buceo autónomo.",
                puntuacion = 4.0,
                foto = "http://elcampesino.co/wp-content/uploads/2019/05/parque-tayrona-banner-1.jpg"
            )


        )
    }*/
}