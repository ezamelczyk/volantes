package volantes.login.model

import org.jetbrains.exposed.sql.Table

object Password : Table() {
    val id = varchar("id", 10).primaryKey()
    val hash = varchar("hash", 60)
}