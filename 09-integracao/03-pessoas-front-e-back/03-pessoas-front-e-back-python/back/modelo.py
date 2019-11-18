from peewee import *

arq = '/home/friend/01-github/programar/09-integracao/03-pessoas-front-e-back/03-pessoas-front-e-back-python/back/pessoas-front-end.db'
db = SqliteDatabase(arq)

class BaseModel(Model):
    class Meta:
        database = db

class Pessoa(BaseModel):
    nome = CharField()
    endereco = CharField()
    telefone = CharField()
    
if __name__ == "__main__":
    db.connect()
    db.create_tables([Pessoa])
    joao = Pessoa.create(nome="Joao da Silva", 
        endereco="Casa 9", telefone="3541-1230")
    print(joao.nome, ",", joao.endereco, ",", joao.telefone)
