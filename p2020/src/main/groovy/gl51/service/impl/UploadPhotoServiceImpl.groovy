package gl51.service.impl

import gl51.data.Photo

import gl51.service.UploadPhotoService
import gl51.service.ResizePhotoService
import gl51.service.MakeThumbnailService
import gl51.service.StockInCloudService
import gl51.service.UpdateDatabaseService

import javax.inject.Inject

class UploadPhotoServiceImpl implements UploadPhotoService {

    @Inject
    ResizePhotoService resizePhotoService

    @Inject
    MakeThumbnailService makeThumbnailService

    @Inject
    StockInCloudService stockInCloudService

    @Inject
    UpdateDatabaseService UpdateDatabaseService

    @Override
    Boolean uploadPhoto() {
        Photo photo = resizePhotoService.resizePhoto()
        Photo thumbnail = makeThumbnailService.makeThumbnail(photo)
        String coord = stockInCloudService.stockInCloud(photo, thumbnail)
        Boolean updated = UpdateDatabaseService.updateDatabase(coord)

        return updated
    }
}