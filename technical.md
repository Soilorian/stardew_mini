# classes

## class ItemDescription

### fields
- Id: ItemId
- Name: String
- price: Double
- iconPath: String

---

## class TileDescription

### fields
- Id: TileId
- Name: String
- iconPath: String

---

## class Item

### fields
- itemId: ItemId

---

## Placeable(Item)

### fields
- placeableOn: List\<TileId>

---

## Growable(Placeable)

### fields
- growResult: ItemId
- stages: List\<Long>

---

## Manufacturer(Placeable)

### fields
- inputToOutput: Map\<ItemId, ItemId>
- stages: List\<Long>

---

## class Usable(Item)
### fields
- action: Action

---

## class Action
### fields
- 

---

## enum ToolType
### values
- HOE
- SCYTHE

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