package packagekb


import grails.testing.mixin.integration.Integration
import grails.transaction.*
import static grails.web.http.HttpHeaders.*
import static org.springframework.http.HttpStatus.*
import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

@Integration
@Rollback
class PackageOnboarding1Spec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the homepage"() {
        when:"The home page is requested"

            File package_file =  getClass().getResource("elsevier_Global_Backfile Package - Computer Science 1995 [BFJCSC95]_2017-09-11_96497 ").file

            def resp = rest.post("$baseUrl/package/elsevier/admin") {
              contentType "multipart/form-data"
              package_file = new File(package_file)
            }

        then:"The response is correct"
            resp.status == OK.value()
            resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
            resp.json.message == 'Welcome to Grails!'
    }

    RestBuilder restBuilder() {
        new RestBuilder()
    }
}
