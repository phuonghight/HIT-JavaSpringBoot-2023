## 1. @value

```
@value("${user.username}")
```

## 2. @PathVariable

Được sử dụng để xác định và trích xuất giá trị của một biến từ URI của request URL
```
@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
   // code xử lý để lấy user theo id truyền vào
}

```

# PostMapping

## @RequestBody

chi nhan json

## @ModelAttribute

nhan object, khong nhan json