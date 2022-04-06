package com.estudos.hackdayimed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estudos.hackdayimed.model.Book

class BooksViewModel : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()

    val books: LiveData<List<Book>> = _books

    fun getBooks() {
        _books.value = buildFakeList()
    }

    private fun buildFakeList(): List<Book>{
        return arrayListOf(
            Book(
                "https://m.media-amazon.com/images/I/41HIuCfCvFL.jpg",
                "Internet das Coisas para Desenvolvedores",
                "Ricardo da Silva Ogliari",
                "A internet das coisas é um dos mais promissores e revolucionários conceitos presentes na ciência da computação. Porém, o conhecimento necessário para trabalhar com plataformas de hardware e microcontroladores nem sempre é de domínio de profissionais com carreira mais direcionada ao mundo do software. Sendo assim, existe uma lacuna que impede que esses desenvolvedores usufruam completamente essa nova onda da internet das coisas.\n" +
                        "Este livro busca diminuir tal distância. O grande objetivo é mostrar ao leitor como podemos compartilhar as informações oriundas de sensores e interagir com atuadores, usando linguagens e plataformas com forte presença no mundo contemporâneo, como Java, JavaScript, Firebase e linguagem C.",
                "Novatec"
            ),
            Book(
                "https://images-na.ssl-images-amazon.com/images/I/41aBxn2AKnL._SX339_BO1,204,203,200_.jpg",
                "Android: do Básico ao Avançado",
                "Ricardo da Silva Ogliari. Robison Cris Brito.",
                "A plataforma de desenvolvimento Android, apesar de relativamente nova, mostra-se robusta e estável para o desenvolvimento dos mais diversos tipos de aplicações móveis. Este livro apresenta os principais recursos utilizados no desenvolvimento de aplicações Android, desde o processo básico de preparação do ambiente e desenvolvimento do primeiro aplicativo, abordando também os principais componentes visuais da plataforma e seu modelo de tratamento de eventos, avançando para a persistência de dados, utilizando o tradicional SQLite e os métodos alternativos de persistência (arquivos, SharedPreference, entre outros). Aprofundando ainda mais, são apresentados recursos como utilização de mapas, dados multimídia (som e imagem) e estudos de casos, como o desenvolvimento de aplicações com Widgets e notificações; comunicação utilizando RSS e HTTP; sensores; recepção de SMS e uso da realidade aumentada.",
                "Ciência Moderna"
            ),
            Book(
                "https://images-na.ssl-images-amazon.com/images/I/41bUl4cVKsL._SY344_BO1,204,203,200_QL70_ML2_.jpg",
                "Homo Deus",
                "Yuval Noah Harari",
                "Neste Homo Deus: uma breve história do amanhã, Yuval Noah Harari, autor do estrondoso best-seller Sapiens: uma breve história da humanidade, volta a combinar ciência, história e filosofia, desta vez para entender quem somos e descobrir para onde vamos. Sempre com um olhar no passado e nas nossas origens, Harari investiga o futuro da humanidade em busca de uma resposta tão difícil quanto essencial: depois de séculos de guerras, fome e pobreza, qual será nosso destino na Terra? A partir de uma visão absolutamente original de nossa história, ele combina pesquisas de ponta e os mais recentes avanços científicos à sua conhecida capacidade de observar o passado de uma maneira inteiramente nova. Assim, descobrir os próximos passos da evolução humana será também redescobrir quem fomos e quais caminhos tomamos para chegar até aqui.",
                "Companhia das Letras"
            )
            /*"Android: do Básico ao Avançado",
            "Internet das Coisas para Desenvolvedores",
            "Homo Deus"*/
        )
    }

}