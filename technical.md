# classes

## class Item

### fields
- itemId: ItemId
- value: Double

---

## Placeable

### fields
- placeableOn: List\<TileId>
---

## Plant

### fields
- placeableOn: List\<TileId>
---

## enum ToolType
### values
- HOE
- SCYTHE

---

## class Tool(Item)
### fields
- toolType: ToolType

### behaviour
- use(location: Coordinates, playerId: Long)

---

## class Player

### fields
- playerId: Long
- activeItem: Item
- inventory: Map\<Long, Long>

### behaviour
- pickup(itemId: Long)
- trash(itemId: Long, count: Long)
- 