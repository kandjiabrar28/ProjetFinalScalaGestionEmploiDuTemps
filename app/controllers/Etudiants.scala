package controllers

import models.Etudiant
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc.{Action, Controller, Flash}

import javax.inject.Inject


/**
 * Controller for etudiants HTTP interface.
 * Injecting configuration:
 * http://stackoverflow.com/questions/36955237/play-2-5-x-method-current-in-object-play-is-deprecated-this-is-a-static-refere
 * Messages and internationalization:
 * https://www.playframework.com/documentation/2.5.x/ScalaI18N
 */

class Etudiants @Inject() (val messagesApi: MessagesApi, implicit val config: Configuration) extends Controller with I18nSupport {

  /* FORM FOR A ETUDIANT */
  private val etudiantForm: Form[Etudiant] = Form(
    mapping(
      "id" -> longNumber,
      "nom" -> nonEmptyText,
      "prenom" -> nonEmptyText,
      "niveau" -> nonEmptyText
    )(Etudiant.apply)(Etudiant.unapply)
  )

  /* FORM FOR A ETUDIANT, TO USE ONLY WHEN CREATING A NEW ETUDIANT */
  private val etudiantNewForm: Form[Etudiant] = Form(
    mapping(
      "id" -> longNumber.verifying("validation.id.duplicate", Etudiant.findById(_).isEmpty),
      "nom" -> nonEmptyText,
      "prenom" -> nonEmptyText,
      "niveau" -> nonEmptyText
    )(Etudiant.apply)(Etudiant.unapply)
  )

  /* RENDER ETUDIANT List IN list OBJECT, LOCATED IN FOLDER wiews\etudiants */
  def list = Action { implicit request =>
    val etudiants = Etudiant.findAll
    Ok(views.html.etudiants.list(etudiants))
  }

  /* SHOW DETAILS OF A ETUDIANT IN details OBJECT IN FOLDER wiews\etudiants */
  def show(id: Long) = Action { implicit request =>
    Etudiant.findById(id) match {
      case None => BadRequest(Messages("etudiants.edit.notfound"))   //NotFound
      case some: Option[Etudiant] => Ok(views.html.etudiants.details(some.get))
    }
  }

  /* SHOW FORM FOR ADDING A NEW ETUDIANT */
  def newEtudiant = Action { implicit request =>
    val form =
      if (request.flash.get("error").isDefined)
        etudiantForm.bind(request.flash.data)
      else
        etudiantForm
    Ok(views.html.etudiants.newEtudiant(form))
  }

  /* SAVING A NEW ETUDIANT, AND VALIDATION OF USER INPUT IN NEW ETUDIANT FORM */
  def save = Action { implicit request =>
    def showErrors(form: Form[Etudiant]) = {
      Redirect(routes.Etudiants.newEtudiant()).flashing(Flash(form.data) +
      ("error" -> Messages("validation.errors")))
    }

    def saveAndShow(newEtudiant: Etudiant) = {
      Etudiant.add(newEtudiant)
      val message = Messages("etudiants.new.success", newEtudiant.nom)
      Redirect(routes.Etudiants.show(newEtudiant.id)).flashing("success" -> message)
    }

    val newEtudiantForm = etudiantNewForm.bindFromRequest()
    newEtudiantForm.fold(
      hasErrors = { form => showErrors(form) },
      success = { newEtudiant => saveAndShow(newEtudiant) }
    )
  }

  /* SHOW FORM FOR EDITING AN EXISTING ETUDIANT */
  def editEtudiant(id: Long) = Action { implicit request =>
    Etudiant.findById(id) match {
      case None => BadRequest(Messages("etudiants.edit.notfound"))
      case some =>
        val etudiant = some.get
        val form = etudiantForm.fill(etudiant)
        Ok(views.html.etudiants.editEtudiant(form))
    }
  }

  /* SAVING AN UPDATED ETUDIANT, AND VALIDATION OF USER INPUT IN FORM */
  def update(id: Long) = Action { implicit request =>
    def showErrors(form: Form[Etudiant]) = {
      Redirect(routes.Etudiants.editEtudiant(id)).flashing(Flash(form.data) +
      ("error" -> Messages("validation.errors")))
    }

    def updateAndShow(updatedEtudiant: Etudiant) = {
      Etudiant.update(updatedEtudiant) match {
        case None => BadRequest(Messages("etudiants.edit.notfound"))
        case some =>
          val message = Messages("etudiants.edit.success", updatedEtudiant.nom)
          Redirect(routes.Etudiants.show(updatedEtudiant.id)).flashing("success" -> message)
      }
    }

    val updatedEtudiantForm = etudiantForm.bindFromRequest()
    updatedEtudiantForm.fold(
      hasErrors = { form => showErrors(form) },
      success = { updatedEtudiant => updateAndShow(updatedEtudiant) }
    )
  }

  /* REMOVING AN EXISTING ETUDIANT */
  def remove(id: Long) = Action { implicit request =>
    Etudiant.findById(id) match {
      case None => BadRequest(Messages("etudiants.edit.notfound"))
      case some =>
        val etudiant = some.get
        Etudiant.remove(etudiant)
        val message = Messages("etudiants.remove.success", etudiant.nom)
        Redirect(routes.Etudiants.list()).flashing("success" -> message)
    }
  }

}
