# classes

## class ItemDescription

### fields
- id: ItemDescriptionId
- Name: String
- price: Double
- iconPath: String

---

## class TileDescription

### fields
- id: TileDescriptionId
- Name: String
- iconPath: String

---

## class Tile

### fields
- tileDescriptionId: TileDescriptionId

---

## class Item

### fields
- itemDescriptionId: ItemDescriptionId

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

## GrowingCrop(Growable)

### fields
- currentProgress: Long
- watered: Boolean

---

## Manufacturer(Placeable)

### fields
- input: ItemId
- output: ItemId
- duration: Long

---

## ArtisanMachine(Manufacturer)

### fields
- currentProgress: Long

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

## class Game

### fields
- Tiles: [][]TileId
- growingCrops: Map\<Point, GrowingCrop>
- machines: Map\<Point, ArtisanMachine>
- player: Player
- house: House

### behaviour

- update(deltaTime: Double)
- render(cameraX: Long, cameraY: Long, cameraWidth: Long, cameraHeight: Long, scale: Int)

---

## class Player

### fields
- playerId: Long
- activeItem: Item
- inventory: Map\<ItemId, count>

### behaviour
- pickup(itemId: Long)
- trash(itemId: Long, count: Long)
