# Android Application  - Consuming [api.mercadolibre.com](https://developers.mercadolibre.com.ar/)

## Description
The application can show products and his detail from a specific search made by the user

### Architecture
The architecture of this application is based, apply and development with the following points.
- A single feature activity architecture. It use the navigation component to manage the different fragments can a feature can have.
- Implement a Model-View-ViewModel pattern to split the development of the graphical user interface.
- Modular app architecture, it permit a features developed features in isolation, independently from other features.
- Android architecture components, part of Android Jetpack for give to project a robust design, testable and maintainable.


### Modules
Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality (Android documentation). In this case apart from dividing by functionality/responsibility, existing the following dependence between them:

![Modules](""https://github.com/essebas/MeliApp/blob/trunk/readme-images/Architecture_Diagram.jpg")