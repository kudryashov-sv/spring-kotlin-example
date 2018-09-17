package mapbench

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.ConcurrentHashMap



@RestController
class Controller {
    private val data: ConcurrentHashMap<UUID, Model> = ConcurrentHashMap()

    @GetMapping("/{id}")
    @ResponseBody
    fun getEntity(@PathVariable(name = "id") id: String): ResponseEntity<Model> {
        val value = this.data[UUID.fromString(id)] ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(value, HttpStatus.OK)
    }

    @PostMapping("/")
    fun upsertEntity(@RequestBody value: Model): ResponseEntity<*> {
        value.updatedAt = Date()
        this.data[value.id!!] = value
        return ResponseEntity<Void>(HttpStatus.NO_CONTENT)
    }
}
