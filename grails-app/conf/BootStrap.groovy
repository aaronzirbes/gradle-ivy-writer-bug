class BootStrap {

    def init = { servletContext ->
        println '============'
        println 'Hello World.'
        println '============'
        println 'Hit CTRL-C to exit.'
    }
    def destroy = {
    }
}
