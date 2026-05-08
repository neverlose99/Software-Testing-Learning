# Phân tích Control Flow Graph & Cyclomatic Complexity
## Phương thức `Triangle.classify`

---

## 1. Mã nguồn gốc

```java
public class Triangle {
    public static String classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Invalid";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a triangle";
        }
        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}
```

---

## 2. Control Flow Graph (CFG)

### Danh sách nút (Nodes)

| Nút | Loại      | Nội dung                              |
|-----|-----------|---------------------------------------|
| N1  | START     | Bắt đầu phương thức                   |
| N2  | Decision  | `if (a≤0 \|\| b≤0 \|\| c≤0)`         |
| N3  | Return    | `return "Invalid"`                    |
| N4  | Decision  | `if (a+b≤c \|\| a+c≤b \|\| b+c≤a)`   |
| N5  | Return    | `return "Not a triangle"`             |
| N6  | Decision  | `if (a==b && b==c)`                   |
| N7  | Return    | `return "Equilateral"`                |
| N8  | Decision  | `if (a==b \|\| b==c \|\| a==c)`       |
| N9  | Return    | `return "Isosceles"`                  |
| N10 | Return    | `return "Scalene"`                    |
| N11 | END       | Kết thúc phương thức                  |

> **Tổng:** N = 11 nút

### Danh sách cạnh (Edges)

| Cạnh | Từ  | Đến | Điều kiện |
|------|-----|-----|-----------|
| e1   | N1  | N2  | —         |
| e2   | N2  | N3  | true      |
| e3   | N2  | N4  | false     |
| e4   | N4  | N5  | true      |
| e5   | N4  | N6  | false     |
| e6   | N6  | N7  | true      |
| e7   | N6  | N8  | false     |
| e8   | N8  | N9  | true      |
| e9   | N8  | N10 | false     |
| e10  | N3  | N11 | —         |
| e11  | N5  | N11 | —         |
| e12  | N7  | N11 | —         |
| e13  | N9  | N11 | —         |
| e14  | N10 | N11 | —         |
| e15  | N11 | —   | (end)     |

> **Tổng:** E = 15 cạnh

---

## 3. Cyclomatic Complexity (CC)

### Công thức

$$CC = E - N + 2P$$

Trong đó:
- **E** = 15 (số cạnh)
- **N** = 11 (số nút)
- **P** = 1 (số thành phần liên thông)

$$CC = 15 - 11 + 2 \times 1 = \mathbf{5}$$

### Kiểm tra nhanh

| Nút quyết định | Điều kiện                              |
|----------------|----------------------------------------|
| N2             | `a≤0 \|\| b≤0 \|\| c≤0`              |
| N4             | `a+b≤c \|\| a+c≤b \|\| b+c≤a`        |
| N6             | `a==b && b==c`                         |
| N8             | `a==b \|\| b==c \|\| a==c`            |

$$CC = \text{Số predicates} + 1 = 4 + 1 = \mathbf{5}$$

> **Kết quả: CC = 5**



## 4. Các đường đi độc lập (Independent Paths)

CC = 5 → có **5 đường đi cơ sở (basis paths)**:

| Path | Đường đi                           | Kết quả           |
|------|------------------------------------|-------------------|
| P1   | N1→N2→N3→N11                       | `"Invalid"`       |
| P2   | N1→N2→N4→N5→N11                    | `"Not a triangle"`|
| P3   | N1→N2→N4→N6→N7→N11                 | `"Equilateral"`   |
| P4   | N1→N2→N4→N6→N8→N9→N11             | `"Isosceles"`     |
| P5   | N1→N2→N4→N6→N8→N10→N11            | `"Scalene"`       |



## 5. Test cases tối thiểu

| TC | a  | b  | c  | Đường đi | Kết quả mong đợi  |
|----|----|----|----|----------|-------------------|
| 1  | -1 | 2  | 3  | P1       | `"Invalid"`       |
| 2  | 1  | 2  | 10 | P2       | `"Not a triangle"`|
| 3  | 3  | 3  | 3  | P3       | `"Equilateral"`   |
| 4  | 3  | 3  | 4  | P4       | `"Isosceles"`     |
| 5  | 3  | 4  | 5  | P5       | `"Scalene"`       |

> **Kết luận:** Cần tối thiểu **5 test case** để đạt *basis path coverage* theo tiêu chí Cyclomatic Complexity.
