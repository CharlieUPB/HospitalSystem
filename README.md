Nota: Para ver la version final cambiar a la rama (branch) dev.

El presente programa es una aplicación web que permite ser utilizada por cualquier navegador o móvil. Del mismo modo es totalmente responsive adaptando sus dimensiones para celulares, computadoras y tablets.
Esta es la pagina de inicio que se muestra del programa:
![Image description](https://i.imgur.com/lkaUX7B.png)

Si se va al menú de Doctores, redirige a la lista de doctores registrados en el sistema, con su respectiva información, asi como la posibilidad de registrar a un nuevo doctor.













Si se presiona el botón “Registrar Doctor”,  se abre un formulario donde se puede registrar a un nuevo doctor que será almacenado en la base de datos del sistema.










Si se selecciona la opción Pacientes, se muestra la lista de pacientes registrados actualmente, adicionalmente se cuenta con 2 opciones. La de registrar a un nuevo paciente y la de ver el historial clínico de un paciente (eventos) o la de editar la información del paciente.














Si se selecciona la opción registrar paciente, se abre un formulario en el cual se solicitan los datos del nuevo paciente.










Si se selecciona la opción eventos, automáticamente se muestra el historial de eventos relacionados al paciente.








Del mismo modo si se ingresa a la sección de reportes, utilizando únicamente el código del paciente también se puede ver el historial clínico del mismo.
 
Finalmente en la sección de Agendamiento se puede visualizar, la lista de citas por fecha. Donde se puede seleccionar la fecha para poder ver todas las citas registradas en el agendamiento del hospital.
Asi mismo se puede crear un nuevo agendamiento simplemente ingresando los datos del doctor, paciente, fecha y hora en la que se realizara el agendamiento.












Por ultimo el sistema por dentro funciona en tiempo real, por lo que ejecuta acciones que actualizan la información y datos en tiempo real. Por ejemplo si se genera una agendamiento o derivación, automáticamente se genera el ACK desde la parte receptora y solo si se recibe dicho ACK se procede a almacenar la información en la base de datos.
 
