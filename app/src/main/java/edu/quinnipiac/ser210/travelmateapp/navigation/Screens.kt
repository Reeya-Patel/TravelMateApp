package edu.quinnipiac.ser210.travelmateapp.navigation

enum class Screens {
    HomeScreen,
    BrowseCountriesScreen,
    CountryDetailsScreen,
    PlanningScreen;

    companion object {
        fun fromRoute(route: String?): Screens =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                BrowseCountriesScreen.name -> BrowseCountriesScreen
                CountryDetailsScreen.name -> CountryDetailsScreen
                PlanningScreen.name -> PlanningScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}
