- [anvil/docs/INTERNALS.md](https://github.com/square/anvil/blob/aa87b694d87dc2f9ee51eb150c33c30a29658029/docs/INTERNALS.md)
- [divkit](https://github.com/divkit/divkit/tree/main)
- [KotlinCompilerPluginExample](https://github.com/Foso/KotlinCompilerPluginExample)

Goal:

```Kotlin
interface Modifier

data class Button(@Event val onClick: () -> Unit) : Component
data class Column(@Group val children: List<Component>, val modifier: Modifier) : Component
data class Text(val verbatim: String, modifier: Modifier) : Component

@State
var isHidden: Boolean = true

Column(modifier = Modifier.padding(24)) {
    Text("Hello, world!", modifier = Modifier.visibility($isHidden)) // @Binding in visibility

    Button {
        isHidden = !isHidden
    }
}
```