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
  path <- "Rplot/shuffles.csv"

  logs <- read.csv(path)

  fun.1 <- function(x) 2 * x / 3

  plot <- logs %>%
    ggplot(mapping = aes(x = cards, y = shuffles)) +
    geom_line(alpha = 0.1) +
    geom_point()

  plot <- logs %>%
    ggplot(data = data.frame(x = 0), mapping = aes(x = x))

  plot +
    stat_function(fun = fun.1) +
    xlim(0, 2000)

  output$distPlot <- renderPlotly({
    #plot
    ggplotly(plot, tooltip = c("cards", "shuffles"))
  })
}

# Run the application
shinyApp(ui = ui, server = server)

#TEMP TODO:
path <- "Rplot/shuffles.csv"

logs <- read.csv(path)

#plot <- logs %>%
#  ggplot(mapping = aes(x = cards, y = shuffles)) +
#  geom_point()

fun.0 <- function(x) x
fun.1 <- function(x) 2 * x / 3
fun.2 <- function(x) 4 * x / 5
fun.3 <- function(x) x / 2
fun.4 <- function(x) x / 3
fun.5 <- function(x) x / 5


plot <-
  ggplot(data = data.frame(x = 0), mapping = aes(x = x)) +
    geom_point(data = logs, mapping = aes(x = cards, y = shuffles)) +
    stat_function(fun = fun.0) +
    stat_function(fun = fun.1) +
    stat_function(fun = fun.2) +
    stat_function(fun = fun.3) +
    stat_function(fun = fun.4) +
    stat_function(fun = fun.5) +
    xlim(0, 2000)

plot
