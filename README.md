# Library App

 - ### Portuguese
Este projeto tem como objetivo demonstrar e explicitar meus estudos sobre desenvolvimento Android utilizando Kotlin. No presente momento, o aplicativo é capaz de conectar-se a API de dados mockados, utilizando o site [Mockable.io](https://www.mockable.io/), este que tem por objetivo dar base aos estudos e dados para ao app. No momento está apenas fazendo o login, porém serão implementadas novas funcionalidades conforme for desenvolvendo os estudos.

## Especificações do projeto

 O projeto foi desenvolvido utilizando a versão do Android Studio 3.0.1, Gradle 3.0.1 e Kotlin 1.1.51. Recomenda-se instalar o plugin Kotlin, se o Android Studio for de versões anteriores a versão 3.0, após instalado o plugin o projeto deverá ser compilado normalmente.

## Organização do projeto

A arquitetura do projeto segue os conceitos da  [Clean architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)  e é utilizado o Model-View-Presenter para a camada de apresentação.

Ainda que estejamos seguindo o clean architecture, por questões de simplicidade, as mesmas entidades foram utilizadas em todas as camadas da aplicação. Visto que não eram necessárias alterações ou transformações dos dados.

A estrutura em módulos do projeto é a seguinte:

-   `commons`: Contém classes e ferramentas utilizada por todos os projetos
-   `flow`: Contém todos os fluxos do aplicativo, dentro de cada flow será colocados pacotes de **view, model, presenter**
- `flow.view` dentro da view será contido todos os elementos que são responsáveis por ação de layout como **activitys, fragments, adapter, etc..**
- `flow.model` dentro da model serão contidos os modelos de dados utilizado e também classes que lidam com eles (persistencia, chamadas a API, etc..)
- `flow.presenter`estarão as classes que mandaram nas ações que cada view de cada fluxo tomará

## Bibliotecas e frameworks utilizados

-   [Retrofit](http://square.github.io/retrofit/): para as chamadas REST.
-   [Timber](https://github.com/JakeWharton/timber): para logs
-   [Glide](https://github.com/bumptech/glide): para loading de imagens.
-   [Moshi](https://github.com/square/moshi): para mapeamento de JSON -> objeto
-   [Android Support Libraries](https://developer.android.com/topic/libraries/support-library/index.html): para implementação da UI das telas- 
-   [RxJava](https://github.com/ReactiveX/RxJava): plugin para facilitar a implementação de programação reativa
- [RxBinding](https://github.com/JakeWharton/RxBinding): Uma Api  RxJava para fazer bind dos Widgets do android

# Licença
```
Copyright 2017 Bruno Henrique de Almeida

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```