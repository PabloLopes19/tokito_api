
# Tokito Api

Uma API de cadastro de alunos e professores para gerenciamento de turmas e horários pode ser organizada em três principais áreas: cadastro de usuários, gerenciamento de turmas e agendamento de horários.

## Cadastro de Alunos e Professores:
 
#### POST `/users`
Cadastra um novo aluno ou professor com dados como nome, e-mail, tipo de usuário (aluno ou professor), etc.

#### GET `/users/{id}`
Retorna informações detalhadas de um usuário específico.

#### PUT `/users/{id}`
Atualiza os dados de um aluno ou professor.

#### DELETE `/users/{id}`
Exclui um usuário.

## Gerenciamento de Turmas:

#### POST `/classes` 
Cria uma nova turma com dados como nome da turma, curso, professor responsável, etc.

#### GET `/classes/{id} `
Retorna detalhes de uma turma específica.

#### PUT `/classes/{id} `
Atualiza informações de uma turma.

#### DELETE `/classes/{id} `
Exclui uma turma.

## Agendamento de Horários:

#### POST `/schedules`
Cria um novo horário para uma turma, especificando o dia da semana, horário de início e fim, e turma associada.

#### GET `/schedules `
Lista todos os horários agendados.

#### PUT `/schedules/{id}`
Atualiza o horário de uma turma.

#### DELETE `/schedules/{id}`
Remove um horário agendado.
