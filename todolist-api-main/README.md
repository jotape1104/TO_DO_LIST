Projeto de uma To-do List feito em grupo para a A3 das UCs da 4a fase do curso de Análise e Desenvolvimento de Sistemas da UNISUL.

Melhorias da manutenção preventiva: Removemos a necessidade de passar tasks diretamente, usamos a função setTasks com o valor anterior para simplificar a função handleDelete e removemos margens desnecessárias no CSS.

## Teste unitário

- caminho: ``src/test/java/com/karlos/todolist/controller/TaskControllerTest.java``

O teste testCreateTask foi criado para verificar se o método createTask do controlador TaskController está funcionando corretamente ao adicionar uma nova tarefa. O objetivo é confirmar que o método devolve uma resposta de sucesso após a criação.
Para isso, o teste configura o taskService — que é o serviço responsável por gerenciar as tarefas — para retornar a mensagem "Task created successfully" quando uma nova tarefa é criada. Após essa configuração, o teste chama o método createTask e verifica se a resposta realmente contém a mensagem esperada. Dessa forma, garantimos que o createTask está funcionando como previsto e chamando o serviço de criação com o parâmetro adequado.
