# Application name
application.name = Gestion de estudiantes

# Messages for Details page
id = Id
nom = Nombre
prenom = Prenombre
niveau = Niveau
etudiants.details = Estudiante: {0}

# Messages for New Student page
etudiants.form = Detalles del producto
etudiants.new = (nuevo)
etudiants.new.command = Añadir
etudiants.new.submit = Añadir
etudiants.new.success = Estudiante {0} añadido.

# Messages for the Edit Student page
etudiants.edit = (existente)
etudiants.edit.command = Editar
etudiants.edit.submit = Guardar
etudiants.edit.success = Estudiante {0} actualizado.
etudiants.edit.notfound = Estudiante no encontrado.

# Messages for the Remove Student Page
etudiants.remove.command = Eliminar
etudiants.remove.success = Estudiante {0} eliminado.

validation.errors = Corrija los errores en el formulario.
validation.ean.duplicate = Ya existe un producto con este Id


# Override of Default messages
# Default messages source is at:
# https://github.com/playframework/playframework/blob/master/framework/src/play/src/main/resources/messages.default

# --- Constraints
constraint.required=Requerido
constraint.min=Valor mínimo: {0}
constraint.max=Valor máximo: {0}
constraint.minLength=Longitud mínima: {0}
constraint.maxLength=Longitud máxima: {0}
constraint.email=Email
constraint.pattern=Patrón requerido: {0}

# --- Formats
format.date=Fecha (''{0}'')
format.numeric=Número
format.real=Real
format.uuid=UUID

# --- Patterns for Formats
formats.date=yyyy-MM-dd

# --- Errors
error.invalid=Valor no válido
error.invalid.java.util.Date=Fecha no válida
error.required=Este campo es requerido
error.number=Se espera un valor numérico
error.real=Se espera un número real
error.real.precision=Se espera un número real con no más de {0} digito(s) incluyendo {1} decimale(s)
error.min=Debe ser mayor o igual a {0}
error.min.strict=Debe ser estrictamente mayor a {0}
error.max=Debe ser menor o igual a {0}
error.max.strict=Debe ser estrictemente menor a {0}
error.minLength=La longitud mínima es {0}
error.maxLength=La longitud máxima es {0}
error.email=Se requiere un email válido
error.pattern=Debe satisfacer {0}
error.date=Se requiere una fecha válida
error.uuid=Se requiere un UUID válido

error.expected.date=Se espera un valor de fecha
error.expected.date.isoformat=Se espera un valor de fecha en formato ISO
error.expected.time=Se espera un valor de hora
error.expected.jsarray=Se espera un arreglo (Array)
error.expected.jsboolid=Se espera un valor boolido (Boolid)
error.expected.jsnumber=Se espera un valor numérico (Number)
error.expected.jsobject=Se espera un valor objeto (Object)
error.expected.jsstring=Se espera un valor cadena de texto (String)
error.expected.jsnumberorjsstring=Se espera un valor numérico (Number) o cadena de texto (String)
error.expected.keypathnode=Se espera un valor nodo (Node)
error.expected.uuid=Se espera un valor UUID
error.expected.validenumvalue=Se espera un valor de enumeración (enumeration) válido
error.expected.enumstring=Se espera un valor cadena de texto (String)

error.path.empty=ruta vacía
error.path.missing=ruta no encontrada
error.path.result.multiple=Múltiples resultados para la ruta dada
