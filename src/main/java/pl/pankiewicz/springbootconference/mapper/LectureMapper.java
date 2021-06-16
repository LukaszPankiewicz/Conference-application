package pl.pankiewicz.springbootconference.mapper;

import org.springframework.stereotype.Service;
import pl.pankiewicz.springbootconference.domain.Lecture;
import pl.pankiewicz.springbootconference.domain.LectureDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureMapper {

    public Lecture mapToLecture(final LectureDto lectureDto) {
        return new Lecture(
                lectureDto.getId(),
                lectureDto.getDate(),
                lectureDto.getStartTime(),
                lectureDto.getEndTime()
        );
    }

    public LectureDto mapToLectureDto(final Lecture lecture) {
        return new LectureDto(
                lecture.getId(),
                lecture.getDate(),
                lecture.getStartTime(),
                lecture.getEndTime()

        );
    }

    public List<LectureDto> mapToLectureDtoList(final List<Lecture> lectureList) {
        return lectureList.stream()
                .map(this::mapToLectureDto)
                .collect(Collectors.toList());
    }
}

