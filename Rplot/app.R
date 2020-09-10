#
# This is a Shiny web application. You can run the application by clicking
# the 'Run App' button above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#


library("shiny")
library("plotly")
library("tidyverse")

# Define UI for application that draws a histogram
ui <- fluidPage(

    # Application title
    titlePanel("Shuffles, see https://github.com/Omnieboer/Shuffle"),

    # Show a plot of the generated distribution
    mainPanel(
       plotlyOutput("distPlot")
    )

)

# Define server logic required to draw a histogram
server <- function(input, output) {
    path <- "shuffles.csv"

    logs <- read.csv(path)

    plot <- logs %>%
        ggplot(mapping = aes(x = cards, y = shuffles)) +
        geom_line()
    output$distPlot <- renderPlotly({
        #plot
        ggplotly(plot, tooltip = c("cards", "shuffles"))
    })
}

# Run the application
shinyApp(ui = ui, server = server)

