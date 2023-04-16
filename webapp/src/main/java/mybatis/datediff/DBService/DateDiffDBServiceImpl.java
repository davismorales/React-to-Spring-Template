package mybatis.datediff.DBService;

import org.springframework.beans.factory.annotation.Autowired;

import mybatis.datediff.mapper.DateDiffMapper;
import mybatis.datediff.model.DateDiff;

public class DateDiffDBServiceImpl {
	
	@Autowired
	private DateDiffMapper dateDiffMapper;
	
	public int calcDiff(DateDiff dateDiff) {
		return dateDiffMapper.insert(dateDiff);
	}

}
