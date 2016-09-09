# avaliacao-webservice
Web Service que tem como recursos:
  - Listar o nome de todos os usuários
    - Resource: /users
    - Param: não tem
    - Return: {"content": [
                  {"name": "user_name1", "inbox": "inbox_size1", "size": "size1"},
                  {"name": "user_name2", "inbox": "inbox_size2", "size": "size2"}
              ]}
  - Pesquisar um usuário pelo seu nome
    - Resource: /user
    - Param: name
    - Return: {"name": "user_name", "inbox": "inbox_size", "size": "size"}
  
  - Buscar qual o usuário com maior inbox
    - Resource: /user_inbox
    - Param: não tem
    - Return: {"name": "user_name", "inbox": "inbox_size", "size": "size"}
    
  - Buscar qual o usuário com maior size
    - Resource: /user_size
    - Param: não tem
    - Return: {"name": "user_name", "inbox": "inbox_size", "size": "size"}
