package packagekb


import grails.rest.*
import grails.converters.*

class PackageController {
	static responseFormats = ['json', 'xml']
	
  def index() { 
    log.debug("packagekb.PackageController::index");
  }

  def admin() { 
    def result = [:]
    log.debug("packagekb.PackageController::admin ${params.vendor}");
    result.message='OK!'
    render result as JSON
  }
}
