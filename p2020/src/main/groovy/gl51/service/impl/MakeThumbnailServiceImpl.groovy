package gl51.service.impl

import gl51.data.Photo

import gl51.service.MakeThumbnailService

class MakeThumbnailServiceImpl implements MakeThumbnailService {

    @Override
    Photo makeThumbnail(Photo photo) {
        //
        photo.setPixels_x(1024)
        photo.setPixels_y(1024)
        return photo
    }

}