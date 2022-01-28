Projet Final Scala
=========================================
Application de gestion d'école et emploi du temps
=========================================

- Application avec Play Framework 2.4 MVC pour implémenter les opérations CRUD sur des classes : Etudiant, Professeur, Matière, Cours et Evaluation.
- Montre comment la composition de Template est possible dans Play Framework.
- Utilise l'injection de dépendances pour injecter la configuration dans les contrôleurs.
- Implémente l'internationalisation.
- N'utilise actuellement aucune base de données ni ORM pour stocker les entités (classes), mais sont stockés en mémoire dans une liste.
- Utilise également un contrôleur pour générer des codes à barres (pour l'identifiant des étudiants).
- Utilise la thématisation du framework Bootstrap.
- Projet généré à l'aide de Lightbend Activator.

Diagramme de Classe de l'application
=====================================
![image](https://user-images.githubusercontent.com/40219530/151613488-b7dea5e5-7c0a-49e3-bbda-493d49beb977.png)

Controllers 
---------------------

- Application.scala:
  Handles HTTP requests to the application's home page.

- Etudiants.scala:
  Controller qui implementent les opérations de CRUD pour la liste des étudiantst.

- Barcodes.scala:
  Generates barcodes pour chaque étudiant de la liste des étudiants.
  
  Oject Etudiant (Classe Etudiant)
  --------------------------------------
  
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



Intellectual property of other parties
--------------------------------------

  Source: je me suis inspiré de l'Application
  Based on the sample application from the book: Play for Scala - Francisco Canedo, Erik Bakker, Peter Hilton, 2013
  https://www.manning.com/books/play-for-scala
  But updated to work on Play Framework 2.2.6
