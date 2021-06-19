package pl.pankiewicz.springbootconference.mapper;

import org.springframework.stereotype.Service;
import pl.pankiewicz.springbootconference.domain.LecturePath;
import pl.pankiewicz.springbootconference.domain.LecturePathDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturePathMapper {

    public LecturePath mapToPath(final LecturePathDto lecturePathDto) {
        return new LecturePath(
                lecturePathDto.getTitle()
        );
    }

    public LecturePathDto mapToLecturePathDto(final LecturePath lecturePath) {
        return new LecturePathDto(
                lecturePath.getId(),
                lecturePath.getTitle()
        );
    }

    public List<LecturePathDto> mapToLecturePathDtoList(final List<LecturePath> lecturePathList) {
        return lecturePathList.stream()
                .map(this::mapToLecturePathDto)
                .collect(Collectors.toList());
    }
}
