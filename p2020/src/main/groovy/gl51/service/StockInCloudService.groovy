package gl51.service

import gl51.data.Photo

interface StockInCloudService {

    String stockInCloud(Photo photo, Photo thumbnail)

}