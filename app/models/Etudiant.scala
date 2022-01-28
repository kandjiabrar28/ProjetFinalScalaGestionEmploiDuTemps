package models


/**
  * case class Etudiant
  * A simple model of a Etudiant.
  */
case class Etudiant(id: Long, nom: String,prenom: String, niveau: String)


/**
  * object Etudiant
  * Companion object for the Etudiant case class.
  */
object Etudiant {

  /**
  * Set containing the instances of Etudiant.
  */
  var etudiants = Set(
    Etudiant(1, "kandji", "cheikh", "Master2"),
    Etudiant(4, "Ndiaye", "Ablaye", "Licence"),
    Etudiant(3, "Diop", "Fatou", "BTS2"),
    Etudiant(2, "Sène", "Astou", "CAP")
  )

  /**
    * findAll: Returns all the etudiants.
    */
  def findAll = etudiants.toList.sortBy(_.id)

  /**
    * findById: Returns an Option[Etudiant] containing the etudiant with the id
    * specified in the parameter.
    */
  def findById(id: Long) = etudiants.find(p => p.id == id)

  /**
    * add: Adds a etudiant to etudiants.
    */
  def add(etudiant: Etudiant) = { etudiants = etudiants + etudiant }

  /**
    * remove: Removes a etudiant from etudiants.
    */
  def remove(etudiant: Etudiant) = { etudiants = etudiants - etudiant }

  /**
    * update: Updates etudiant.
    * Postcondition: Returns an Option, Some[Etudiant] updated etudiant in case
    * etudiant exists, or None in case etudiant doesn't exist. Doesn't create a new
    * etudiant if etudiant doesn't exist previously.
    */
  def update(etudiant: Etudiant) = {
    etudiants.find(p => p.id == etudiant.id) match {
      case None => None
      case some =>
        val current = some.get
        etudiants = etudiants - current + etudiant
        Some(etudiant)
    }
  }

}
