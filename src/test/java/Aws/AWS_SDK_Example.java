package Aws;
import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


public class AWS_SDK_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AWSCredentials credentials = new BasicAWSCredentials("abcd",
				"abcd");

		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();
				// create a bucket
		
		String bucketName = "asad-bucket-1027";
		if(!s3client.doesBucketExistV2(bucketName)) {
			
			s3client.createBucket(bucketName);
			System.out.println("S3 bucket created");
		}

		String fileName = "note";
		String filePath = "C:\\Users\\6666\\Desktop" + fileName;
		
		s3client.putObject(bucketName, fileName, new File(filePath));
		System.out.println("file uploaded");


	}

}
