package packagekb

import grails.gorm.transactions.Transactional
import org.apache.commons.io.FileUtils
import au.com.bytecode.opencsv.CSVReader

/**
 *
 * Package files pass through a specific workflow.
 *   1. initial validation - Make sure the file is structurally sound, and has the mandatory fields
 *   2. Transform the file on disk into Source / SourceFile / SourceFileRow / CustomFieldValue / CustomFieldDefn structures in the DB
 *   3. Attempt to low level validate all the rows. Make sure we know the titles, validate title/id parings etc. This may well be an iterative process. 
 *   4. Merge the package file into our package database proper
 *   5. Delete the temporary structures
 */
@Transactional
class PackageOnboardingService {


  public String submitOnboardingJob(filename, input_stream, vendor) {
    log.debug("submitOnboardingJob");
    def job_id = java.util.UUID.randomUUID().toString()

    // Copy file.inputStream to temporary file
    def target_file = File.createTempFile("package-upload-${job_id}", ".tmp");
    FileUtils.copyInputStreamToFile(input_stream, target_file);

    // Now validate
    log.debug("Copied upload file to temp file, now validate");
  }

  public Map validateSourceFile(File file) {
    log.debug("validateSourceFile");
    def result = [:]

    CSVReader r = new CSVReader( new InputStreamReader(file.inputStream, java.nio.charset.Charset.forName('UTF-8') ) )
    def first = true
    def broken = false
    String[] nl=null;
    while ((nl = r.readNext()) != null && !broken) {
      if ( first ) {
        first = false; // Skip header
      }
      else {
      }
      log.debug("Line ${nl}");
    }


    result.status = true
    result.errors = []
    result
  }


  public void initialLoad() {
  }
}
