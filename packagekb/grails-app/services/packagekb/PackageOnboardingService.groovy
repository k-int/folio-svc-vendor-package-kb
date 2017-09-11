package packagekb

import grails.gorm.transactions.Transactional

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

  public void validateSourceFile() {
  }

  public void initialLoad() {
  }
}
