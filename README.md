# OpenLR 轉換範例程式碼說明
為加速開發者能快速使用交通路段基礎資訊查詢系統（Link）開放之OpenLR資料服務，將來自TomTom OpenLR標準規範之範例程式碼提供開發者下載，使用者可於開發環境開啟後即可依範例程式碼自行擴充，降低學習曲線。

## 說明

### `encoder`
TomTom 編碼器套件中包含OpenLR編碼器的參考，以一個（取決於地圖的）位置作為輸入，並生成一個對應的（與地圖無關的）位置參考。該軟體套件使用 OpenLR map 和 OpenLR data。

### `map`
地圖套件包括地圖界面和地圖工具所使用的OpenLR編碼器和解碼器。此軟體套件的用戶需要實施所需的方法和需要將內部數據結構轉換為OpenLR map介面。

### `maploader-tt-sqlite`
提供訪問層，使OpenLR可以使用SQLite格式的TomTom數字地圖。

### `decoder`
解碼器中包含OpenLR解碼器的參考實現。它以（與地圖無關）的位置參考作為輸入，並找到對應的（與地圖有關的）位置參考。該軟體套件使用OpenLR map和 OpenLR binary。

### `data`
OpenLR data package 含用於 OpenLR 位置引用資料。

### `xml`
OpenLR XML 格式.

### `binary`
包括用於讀寫二進制位置的類別。 OpenLR編碼器使用此套件來創建位置參考的二進製表示形式。 OpenLR解碼器使用此套件來接收和解碼二進制位置參考數據

### `datex2`
該軟件套件用於處理Datex2數據。
